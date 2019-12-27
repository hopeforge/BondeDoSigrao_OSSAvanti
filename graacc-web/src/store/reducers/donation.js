import { SEND_DONATION } from "../actions/donation";

const initialState = {
  donation: {}
};

export default (state = initialState, action) => {
  switch (action.type) {
    case SEND_DONATION:
      return {
        ...state,
      };
    default:
      return state;
  }
};
