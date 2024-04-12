import React from "react";
import { Bar } from "react-chartjs-2";

function Chart() {
  const data = {
    labels: ["January", "February", "March", "April", "May", "June", "July"],
    datasets: [
      {
        label: "My First Dataset",
        data: [65, 59, 80, 81, 56, 55, 40],
        backgroundColor: "rgba(255, 99, 132, 0.2)",
        borderColor: "rgba(255, 99, 132, 1)",
        borderWidth: 1,
      },
    ],
  };

  return <Bar data={data} />;
}

export default Chart;
