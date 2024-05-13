import React, { useState } from "react";
import styled from "styled-components";
import AppBar from "@mui/material/AppBar";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import Button from "@mui/material/Button";
import Menu from "@mui/material/Menu";
import MenuItem from "@mui/material/MenuItem";
import { Link } from "react-router-dom";
import { useCookies } from "react-cookie";
import { userLoggedIn } from "./Auth";

const StyledAppBar = styled(AppBar)`
  background-color: white;
`;

const Title = styled(Typography)`
  flex-grow: 1;
`;

const HeaderButton = styled(Button)`
  margin-left: 8px;
`;

function Header() {
  const [anchorEl, setAnchorEl] = useState(null);
  const open = Boolean(anchorEl);
  const [userLoginStat, setUserLoginStat] = useState(false);
  const [username, setUsername] = useState("");
  const [cookies, setCookies, removeCookieFromStorage] = useCookies([
    "user",
    "token",
  ]);

  useEffect(() => {
    setUserLoginStat(userLoggedIn());
    if (userLoginStat) {
      setUsername(userLoggedIn().replace("user=", ""));
    }
  }, []);

  useEffect(() => {
    if (userLoginStat) {
      setUsername(userLoggedIn().replace("user=", ""));
    }
  }, [userLoginStat]);

  const handleMenu = (event) => {
    setAnchorEl(event.currentTarget);
  };

  const handleClose = () => {
    removeCookieFromStorage("user");
      removeCookieFromStorage("token");
      removeCookieFromStorage("role");
      removeCookieFromStorage("id");
      setUserLoginStat(false);
      console.log(userLoginStat);
      setAnchorEl(null);

      window.location.href = "/login";

  };

  return (
    <StyledAppBar position="static">
      <Toolbar>
        <Title variant="h6">My Website</Title>
        <HeaderButton component={Link} to="/landing" color="inherit">
          Home
        </HeaderButton>
        <HeaderButton component={Link} to="/aboutus" color="inherit">
          About Us
        </HeaderButton>
        <HeaderButton component={Link} to="/services" color="inherit">
          Services
        </HeaderButton>
        <HeaderButton component={Link} to="/signup" color="inherit">
          Sign Up
        </HeaderButton>
        {!userLoginStat && (<HeaderButton component={Link} to="/login" color="inherit">
          Login
        </HeaderButton>)}
        
        {userLoginStat && (<HeaderButton color="inherit" onClick={handleMenu}>
          Username
        </HeaderButton>)}
        
        <Menu
          anchorEl={anchorEl}
          open={open}
          onClose={handleClose}
          PaperProps={{
            elevation: 0,
            sx: {
              overflow: "visible",
              filter: "drop-shadow(0px 2px 8px rgba(0,0,0,0.32))",
              mt: 1.5,
              "& .MuiAvatar-root": {
                width: 32,
                height: 32,
                ml: -0.5,
                mr: 1,
              },
              "&:before": {
                content: '""',
                display: "block",
                position: "absolute",
                top: 0,
                right: 14,
                width: 10,
                height: 10,
                bgcolor: "background.paper",
                transform: "translateY(-50%) rotate(45deg)",
                zIndex: 0,
              },
            },
          }}
          transformOrigin={{ horizontal: "right", vertical: "top" }}
          anchorOrigin={{ horizontal: "right", vertical: "bottom" }}
        >
          <MenuItem onClick={handleClose}>Profile</MenuItem>
          <MenuItem onClick={handleClose}>My account</MenuItem>
          <MenuItem onClick={handleClose}>Logout</MenuItem>
        </Menu>
      </Toolbar>
    </StyledAppBar>
  );
}

export default Header;
