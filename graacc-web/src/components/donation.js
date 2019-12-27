import React, { useState, useCallback } from "react";
import { Route } from "react-router-dom";
import "./donation.css";

import * as donationActions from "../store/actions/donation";

import { useSelector, useDispatch } from "react-redux";

const Donation = () => {
  const [inputNome, setInputNome] = useState("");
  const [inputEmail, setInputEmail] = useState("");
  const [checkReceber, setCheckReceber] = useState("");
  const [selectValor, setSelectValor] = useState("");
  const [isRedirect, setIsRedirect] = useState(false);

  const dispatch = useDispatch();

  const handleSubmit = useCallback(
    async e => {
      e.preventDefault();
      console.log(inputNome);
      console.log(inputEmail);
      console.log(checkReceber);
      console.log(selectValor);

      try {
        await dispatch(
          donationActions.sendDonation(inputNome, inputEmail, selectValor)
        );
        //TODO FAZER ALGO
      } catch (err) {
        console.log(err);
      }
      setIsRedirect(true);
    },
    [dispatch, inputNome, inputEmail, selectValor, checkReceber]
  );
  console.log("REDIRECT " + isRedirect);

  const redirect = () => {
    let url = null;
    console.log(selectValor);

    if (!selectValor) {
      url = "https://graacc.org.br/";
    } else {
      switch (selectValor) {
        case "15":
          url =
            "https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=MCMEACJKT3EBS&source=url";
          break;
        case "35":
          url =
            "https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=JVCXVWCF5GY3Y&source=url";
          break;
        case "50":
          url =
            "https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=GD5HKAGZWFUPS&source=url";
          break;
        case "150":
          url =
            "https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=PFWP7DU8FFYRJ&source=url";
          break;
        case "999":
          url =
            "https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=PFWP7DU8FFYRJ&source=url";
          break;
        default:
          url =
            "https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=PFWP7DU8FFYRJ&source=url";
          break;
      }
    }

    window.location.replace(url);
  };

  if (isRedirect) {
    console.log("REDIRECT " + isRedirect);

    redirect();
    return null;
  }

  return (
    <div class="center">
      <form onSubmit={handleSubmit}>
        <div class="form-group">
          <label for="inputNome">Nome: </label>
          <input
            type="text"
            class="form-control"
            id="inputNome"
            name="inputNome"
            onChange={e => setInputNome(e.target.value)}
          />
        </div>
        <div class="form-group">
          <label for="inputEmail">Email: </label>
          <input
            type="email"
            class="form-control"
            id="inputEmail"
            name="inputEmail"
            aria-describedby="emailHelp"
            onChange={e => setInputEmail(e.target.value)}
          />
          <small id="emailHelp" class="form-text text-muted">
            Nunca compartilhamos seu email
          </small>
        </div>
        <div class="form-check">
          <input
            type="checkbox"
            class="form-check-input"
            id="checkReceber"
            name="checkReceber"
            onChange={e => setCheckReceber(e.target.value)}
          />
          <label class="form-check-label" for="checkReceber">
            Receber email com informações sobre o GRAACC
          </label>
        </div>
        <p></p>
        <div class="form-group">
          <label for="selectValor">Valor a ser doado</label>
          <select
            id="selectValor"
            class="form-control"  
            name="selectValor"
            onChange={e => setSelectValor(e.target.value)}
          >
            <option value="" selected>Escolha um valor</option>
            <option value="15">15</option>
            <option value="35">35</option>
            <option value="50">50</option>
            <option value="150">150</option>
            <option value="999">Outro</option>
          </select>
        </div>
        <button type="submit" class="btn btn-primary btn-lg btn-block">
          Doar
        </button>
      </form>
    </div>
  );
};

export default Donation;
