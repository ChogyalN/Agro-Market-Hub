import React, { useState, useEffect } from "react";
import "../css/header.css";
import { Link, NavLink } from "react-router-dom";
import { useCookies } from "react-cookie";
import { userLoggedIn } from "./Auth";

function Header() {
  const [userLoginStat, setUserLoginStat] = useState(false);
  const [username, setUsername] = useState("");
  const [cookies, setCookies, removeCookieFromStorage] = useCookies(["user", "token"]);

  useEffect(() => {
    setUserLoginStat(userLoggedIn());
    if(userLoginStat){
      setUsername(userLoggedIn().replace("user=", ""));
    }
  }, []);

  useEffect(() => {
    if(userLoginStat){
      setUsername(userLoggedIn().replace("user=", ""));
    }
  }, [userLoginStat]);
 
  const logoutUser = (e) => {
    removeCookieFromStorage("user");
    removeCookieFromStorage("token");
    removeCookieFromStorage("role");
    setUserLoginStat(false);
    console.log(userLoginStat);

    window.location.href = "/login";
  };

  return (
    <header className="shadow sticky z-50 top-0">
      <nav className="bg-white border-gray-200 px-4 lg:px-6 py-2.5">
        <div className="flex flex-wrap justify-between items-center mx-auto max-w-screen-xl">
          <div
            className="hidden justify-between items-center w-full lg:flex lg:w-auto lg:order-1"
            id="mobile-menu-2"
          >
            <ul className="flex flex-col mt-4 font-medium lg:flex-row lg:space-x-8 lg:mt-0">
              <li>
                <NavLink
                  to="/landing"
                  className={({ isActive }) =>
                    `block py-2 pr-4 pl-3 duration-200 ${
                      isActive ? "text-orange-700" : "text-gray-700"
                    } border-b border-gray-100 hover:bg-gray-50 lg:hover:bg-transparent lg:border-0 hover:text-orange-700 lg:p-0`
                  }
                >
                  Home
                </NavLink>
              </li>
              <li>
                <NavLink
                  to="/about"
                  className={({ isActive }) =>
                    `block py-2 pr-4 pl-3 duration-200 ${
                      isActive ? "text-orange-700" : "text-gray-700"
                    } border-b border-gray-100 hover:bg-gray-50 lg:hover:bg-transparent lg:border-0 hover:text-orange-700 lg:p-0`
                  }
                >
                  About
                </NavLink>
              </li>
              <li>
                <NavLink
                  to="/contact"
                  className={({ isActive }) =>
                    `block py-2 pr-4 pl-3 duration-200 ${
                      isActive ? "text-orange-700" : "text-gray-700"
                    } border-b border-gray-100 hover:bg-gray-50 lg:hover:bg-transparent lg:border-0 hover:text-orange-700 lg:p-0`
                  }
                >
                  Contact
                </NavLink>
              </li>
              <li>
                <NavLink
                  to="/github"
                  className={({ isActive }) =>
                    `block py-2 pr-4 pl-3 duration-200 ${
                      isActive ? "text-orange-700" : "text-gray-700"
                    } border-b border-gray-100 hover:bg-gray-50 lg:hover:bg-transparent lg:border-0 hover:text-orange-700 lg:p-0`
                  }
                >
                  Github
                </NavLink>
              </li>
              {!userLoginStat ?(
                <li>
                  <NavLink
                    to="/login"
                    className={({ isActive }) =>
                      `block py-2 pr-4 pl-3 duration-200 ${
                        isActive ? "text-orange-700" : "text-gray-700"
                      } border-b border-gray-100 hover:bg-gray-50 lg:hover:bg-transparent lg:border-0 hover:text-orange-700 lg:p-0`
                    }
                  >
                    LogIn
                  </NavLink>
                </li>
              ):(<></>)}
              {!userLoginStat ?(
                <li>
                  <NavLink
                    to="/signup"
                    className={({ isActive }) =>
                      `block py-2 pr-4 pl-3 duration-200 ${
                        isActive ? "text-orange-700" : "text-gray-700"
                      } border-b border-gray-100 hover:bg-gray-50 lg:hover:bg-transparent lg:border-0 hover:text-orange-700 lg:p-0`
                    }
                  >
                    SignUp
                  </NavLink>
                </li>
              ):(<></>)}
              {userLoginStat ?(
                <li>
                  <NavLink
                    to="/landing"
                    onClick={logoutUser}
                    className={({ isActive }) =>
                      `block py-2 pr-4 pl-3 duration-200 ${
                        isActive ? "text-orange-700" : "text-gray-700"
                      } border-b border-gray-100 hover:bg-gray-50 lg:hover:bg-transparent lg:border-0 hover:text-orange-700 lg:p-0`
                    }
                  >
                    Logout
                  </NavLink>
                </li>
              ):(<></>)}
              {userLoginStat ?(
                <li>
                  <NavLink
                    to="/about"
                    className={({ isActive }) =>
                      `block py-2 pr-4 pl-3 duration-200 ${
                        isActive ? "text-orange-700" : "text-gray-700"
                      } border-b border-gray-100 hover:bg-gray-50 lg:hover:bg-transparent lg:border-0 hover:text-orange-700 lg:p-0`
                    }
                  >
                    {username}
                  </NavLink>
                </li>
              ):(<></>)}
            </ul>
          </div>
        </div>
      </nav>
    </header>
  );
}

export default Header;
