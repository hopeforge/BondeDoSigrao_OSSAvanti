import { SEARCH_LAWSUIT } from "../actions/lawsuit";

const initialState = {
  lawsuits: []
};

export default (state = initialState, action) => {
  switch (action.type) {
    case SEARCH_LAWSUIT:
      return {
        lawsuits: action.lawsuits
      };
    default:
      return state;
  }
};
