export const SEND_EMAIL = "SEND_EMAIL";

export const sendEmail = (listEmails, subject, body) => {
  return async dispatch => {
    try {
      console.log("SEND EMAIL" + listEmails);

      const response = await fetch("http://13.52.219.65:8081/app/api/send-html", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          "Access-Control-Allow-Origin": "http://localhost:3000"
        },
        body: JSON.stringify({
          listEmail: listEmails,
          subjectEmail: subject,
          bodyEmail: body
        })
      });

      if (!response.ok) {
        throw new Error("Something went Wrong!");
      }

      dispatch({
        type: SEND_EMAIL,
        emailData: {
          listEmails,
          subject,
          body
        }
      });
    } catch (error) {
      console.log(error);
    }
  };
};
