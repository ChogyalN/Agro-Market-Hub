import React from "react";
import { useCookies } from "react-cookie";

function CookieTry() {
  const [cookies, setCookies, removeCookieFromStorage] = useCookies(["newCookie"]);

  const handleCookie = () => {
    setCookies("newCookie", "New Cookies", {
      expires: new Date(new Date().getTime() + 2 * 24 * 60 * 60 * 1000),
    });
  };

  const deleteCookie = () => {
    removeCookieFromStorage("newCookie");
    removeCookieFromStorage("user");
    removeCookieFromStorage("token");
    removeCookieFromStorage("role");
  };

  return (
    <>
      <button onClick={handleCookie}>Add cookies</button>
      <button onClick={deleteCookie}>DeleteCookies</button>
    </>
  );
}
export default CookieTry;
