export const fetchToken = () => {
  const token = document.cookie
    .split(";")
    .find((cookie) => cookie.trim().startsWith("token="));
  return token ? token.replace("token=", "") : null;
};

export const userLoggedIn = () => {
  // Check if a token cookie exists
  // return document.cookie
  //   .split(";")
  //   .find((cookie) => cookie.trim().startsWith("user")).replace("user=", "");

  return document.cookie
  .split(";")
  .find((cookie) => cookie.trim().startsWith("user"));
};

export const isUserAdmin = () => {
  const role = document.cookie
    .split(";")
    .find((cookie) => cookie.trim().startsWith("role"));
  if (role !== null) {
    return !!(role.replace("role=", "") === "admin");
  } else {
    console.log("The role is null");
  }
};
