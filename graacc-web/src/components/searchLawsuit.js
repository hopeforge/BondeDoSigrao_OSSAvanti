import React, { useState, useCallback } from "react";
import "./searchLawsuit.css";

import * as lawsuitActions from "../store/actions/lawsuit";

import { useSelector, useDispatch } from "react-redux";

import LawsuitItem from "./lawsuitItem";

const SearchLawsuit = () => {
  const [inputPalavra, setInputPalavra] = useState("");
  const [inputDataInicio, setInputDataInicio] = useState("");
  const [inputDataFim, setInputDataFim] = useState("");

  const dispatch = useDispatch();

  const handleSubmit = useCallback(
    async e => {
      e.preventDefault();
      console.log(inputPalavra);
      console.log(inputDataInicio);
      console.log(inputDataFim);

      try {
        await dispatch(
          lawsuitActions.searchLawsuit(
            inputPalavra,
            inputDataInicio,
            inputDataFim
          )
        );
      } catch (err) {
        console.log(err);
      }
    },
    [dispatch, inputPalavra, inputDataFim, inputDataInicio]
  );

  const lawsuitsArray = useSelector(state => state.lawsuit.lawsuits);
  console.log("SELECTOR = " + lawsuitsArray);

  return (
    <div class="center">
      <form onSubmit={handleSubmit}>
        <div class="form-group">
          <label for="inputPalavra">Palavras Chave: </label>
          <input
            type="text"
            class="form-control"
            id="inputPalavra"
            name="inputPalavra"
            onChange={e => setInputPalavra(e.target.value)}
          />
        </div>
        <div class="form-group">
          <label for="inputDataInicio">Data Inicio: </label>
          <input
            type="text"
            class="form-control"
            id="inputDataInicio"
            name="inputDataInicio"
            onChange={e => setInputDataInicio(e.target.value)}
          />
        </div>
        <div class="form-group">
          <label for="inputDataFim">Data Final: </label>
          <input
            type="text"
            class="form-control"
            id="inputDataFim"
            name="inputDataFim"
            onChange={e => setInputDataFim(e.target.value)}
          />
        </div>
        <button type="submit" class="btn btn-primary btn-lg btn-block">
          Consultar
        </button>
      </form>
      <div>
        {lawsuitsArray.map(item => {
          return <LawsuitItem 
            idprocess={item.idprocess}
            subject={item.subject}
            judge={item.judge}
            court={item.court}
            forum={item.forum}
            district={item.district}
            dateAvailability={item.dateAvailability}
            description={item.description}
          />
        })}
      </div>
    </div>
  );
};

export default SearchLawsuit;
