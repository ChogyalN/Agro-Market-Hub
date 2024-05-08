import React, { useState, useEffect } from "react";
import { styled } from "@mui/system";
import { Container, Paper, Grid, Avatar, IconButton } from "@mui/material";
import EditIcon from "@mui/icons-material/Edit";
import DeleteIcon from "@mui/icons-material/Delete";
import PersonAddIcon from "@mui/icons-material/PersonAdd";
import axios from "axios";

const RootContainer = styled(Container)(({ theme }) => ({
  marginTop: theme.spacing(4),
}));

const ImageContainer = styled("div")({
  display: "flex",
  justifyContent: "center",
});

const AvatarImage = styled(Avatar)(({ theme }) => ({
  width: theme.spacing(15),
  height: theme.spacing(15),
  marginBottom: theme.spacing(2),
}));

const uploadDP = () => {
  // Logic for uploading profile picture
};

const Profile = () => {

    
  return (
    <RootContainer>
      <Paper elevation={10}>
        <ImageContainer>
          <img src="D:\file_upload\2024\May\7\image1.jpeg" alt="Image display" />
        </ImageContainer>
        {/* <DetailsContainer> */}
          <Grid container spacing={2}>
            <Grid item xs={12}>
              <IconButton color="primary">
                <EditIcon />
              </IconButton>
              <IconButton color="secondary">
                <DeleteIcon />
              </IconButton>
              <IconButton>
                <PersonAddIcon />
              </IconButton>
            </Grid>
            <Grid item xs={12}>
              <p>
                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed
                fermentum, eros eu aliquet blandit, urna lorem pretium purus, id
                consequat enim turpis eu mauris.
              </p>
            </Grid>
          </Grid>
        {/* </DetailsContainer> */}
      </Paper>
      <Grid container spacing={2} style={{ marginTop: "2rem" }}>
        <Grid item xs={1}></Grid>
        <Grid item xs={7}>
          {/* First Column */}
          <Paper elevation={3} style={{ height: "100%", padding: "16px" }}>
            {/* Content for first column */}
          </Paper>
        </Grid>
        <Grid item xs={3}>
          {/* Second Column */}
          <Paper elevation={3} style={{ height: "100%", padding: "16px" }}>
            {/* Content for second column */}
          </Paper>
        </Grid>
        <Grid item xs={1}></Grid>
      </Grid>
    </RootContainer>
  );
};

export default Profile;
