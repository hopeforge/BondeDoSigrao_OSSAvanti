export const SEND_DONATION = "SEND_DONATION";

export const sendDonation = (name, email, value) => {
  return async (dispatch) => {
    try {

      console.log('MAILING')

      const response = await fetch('http://13.52.219.65:8082/app/api/mailing', {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          "Access-Control-Allow-Origin": "http://localhost:3000"
        },
        body: JSON.stringify({
          nome: name,
          email
        })
      });

      if (!response.ok) {
        throw new Error("Something went Wrong!");
      }

      dispatch({
        type: SEND_DONATION,
        donationData: {
          name,
          email,
          value
        }
      });
    } catch (error) {
      console.log(error);
    }
  };
};
