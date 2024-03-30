import React, { useState, useEffect } from "react";
import axios from "axios";
import "../css/product.css";

function ProductList() {
  const [products, setProducts] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    console.log("I am inside effect");
    const fetchProducts = async () => {
      try {
        const response = await axios.get("/api/v1/getProducts"); // Replace '/api/products' with your API endpoint
        setProducts(response.data);
        setLoading(false);
      } catch (error) {
        setError(error.message);
        setLoading(false);
      }
    };

    fetchProducts();
    console.log("I am after effect");
  }, []);

  return (
    <div className="product-table-container">
      <table className="product-table">
        <thead>
          <tr>
            <th>Product Name</th>
            <th>Description</th>
            <th>Quantity</th>
            <th>Unit Price</th>
            <th>Unit</th>
            <th>Available Date</th>
            <th>Status</th>
          </tr>
        </thead>
        <tbody>
          {products.map((product, index) => (
            <tr key={index}>
              <td>{product.productName}</td>
              <td>{product.productDesc}</td>
              <td>{product.quantity}</td>
              <td>{product.unitPrice}</td>
              <td>{product.unit}</td>
              <td>{product.availableDate}</td>
              <td>{product.status}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default ProductList;
