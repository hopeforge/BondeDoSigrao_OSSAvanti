import { SEND_EMAIL } from "../actions/email";

const initialState = {
  email: {}
};

export default (state = initialState, action) => {
  switch (action.type) {
    case SEND_EMAIL:
      return {
        ...state,
      };
    default:
      return state;
  }
};
