import Lawsuit from "../../model/lawsuit";

export const SEARCH_LAWSUIT = "SEARCH_LAWSUIT";

export const searchLawsuit = (searchWords, initDate, endDate) => {
  return async dispatch => {
    try {
      console.log("DISPATCH");

      const response = await fetch(
        `http://13.52.219.65:8080/app/api/findprocess?filter=${searchWords}&startDate=${initDate}&finishDate=${endDate}`,
        //`http://localhost:8080/findprocess?filter=${searchWords}&startDate=${initDate}&finishDate=${endDate}`,
        {
          method: "GET",
          headers: {
            "Access-Control-Allow-Origin": "http://localhost:3000"
          }
        }
      );

      if (!response.ok) {
        throw new Error("Something went Wrong!");
      }

      const responseData = await response.json();

      const lawsuitsArray = [];

      for (const key in responseData) {
        lawsuitsArray.push(
          new Lawsuit(
            responseData[key].idprocess,
            responseData[key].typeClass,
            responseData[key].subject,
            responseData[key].judge,
            responseData[key].district,
            responseData[key].forum,
            responseData[key].court,
            responseData[key].dateAvailability,
            responseData[key].description
          )
        );
      }

      dispatch({
        type: SEARCH_LAWSUIT,
        lawsuits: lawsuitsArray
      });
    } catch (error) {
      console.log(error);
    }
  };
};
