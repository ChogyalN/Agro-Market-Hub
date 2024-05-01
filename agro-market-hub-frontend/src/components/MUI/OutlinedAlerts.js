import * as React from "react";
import Alert from "@mui/material/Alert";
import Stack from "@mui/material/Stack";

export default function OutlinedAlerts() {
  return (
    <Stack
      sx={{
        width: "90%",
        margin: "0 auto", // Horizontal centering
        // textAlign: "center", // Center align content inside the Stack
        // minHeight: "100vh", // Ensure Stack takes up full viewport height
        display: "flex",
        flexDirection: "column",
        justifyContent: "center",
      }}
      spacing={2}
    >
      <Alert variant="outlined" severity="success">
        The user is created succcessfully.
      </Alert>
      <Alert variant="outlined" severity="info">
        This is an outlined info Alert.
      </Alert>
      <Alert variant="outlined" severity="warning">
        This is an outlined warning Alert.
      </Alert>
      <Alert variant="outlined" severity="error">
        This is an outlined error Alert.
      </Alert>
    </Stack>
  );
}
