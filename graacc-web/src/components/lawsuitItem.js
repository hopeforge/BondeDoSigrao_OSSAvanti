import React, { useState, useCallback } from "react";

import { useSelector, useDispatch } from "react-redux";

import * as emailActions from "../store/actions/email";


const LawsuitItem = props => {
  const [showMore, setShowMore] = useState(false);

  const dispatch = useDispatch();

  const sendEmailhandler =  useCallback(
    async () => {

      try {
        await dispatch(
          emailActions.sendEmail(['lvmarquezani@indracompany.com'], 'Teste', 'Teste Body')
        );
      } catch (err) {
        console.log(err);
      }
    }, [dispatch]);

  return (
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">{props.idprocess}</h5>
        <h6 class="card-subtitle mb-2 text-muted">{props.subject}</h6>
        <h6 class="card-subtitle mb-2 text-muted">{props.judge}</h6>
        <h6 class="card-subtitle mb-2 text-muted">{props.court}</h6>
        <h6 class="card-subtitle mb-2 text-muted">{props.forum}</h6>
        <h6 class="card-subtitle mb-2 text-muted">{props.district}</h6>
        <h6 class="card-subtitle mb-2 text-muted">{props.dateAvailability}</h6>

        {showMore && <p class="card-text">{props.description}</p>}
        {!showMore && <p class="card-text">{props.description.slice(0, 200)}...</p>}
        
        {showMore &&  <a href="#" class="card-link" onClick={() => {setShowMore(false);}}>Menos Info</a>}
        {!showMore &&  <a href="#" class="card-link" onClick={() => {setShowMore(true);}}>Mais Info</a>}

        <a href="#" class="card-link" onClick={sendEmailhandler}>
          Enviar por email
        </a>
      </div>
    </div>
  );
};

export default LawsuitItem;
