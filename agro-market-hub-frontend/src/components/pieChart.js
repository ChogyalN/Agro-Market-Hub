import React from "react";
import { PieChart, Pie, Tooltip, Legend, Cell } from "recharts";

const PieChartComponent = () => {
  const data = [
    { name: "Group A", value: 400, color: "#FF5733" },
    { name: "Group B", value: 300, color: "#FFC300" },
    { name: "Group C", value: 300, color: "#36A2EB" },
    { name: "Group D", value: 200, color: "#4CAF50" },
    { name: "Group B", value: 300, color: "#FFC300" },
  ];

  return (
    <PieChart width={500} height={500}>
      <Pie
        data={data}
        dataKey="value"
        nameKey="name"
        cx="50%"
        cy="50%"
        outerRadius={100}
        label
        fill="#8884d8"
      >
        {data.map((entry, index) => (
          <Cell key={`cell-${index}`} fill={entry.color} />
        ))}
      </Pie>
      <Tooltip />
      <Legend />
    </PieChart>
  );
};

export default PieChartComponent;
