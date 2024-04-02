import React, { useState, useEffect } from "react";
import axios from "axios";
import "../css/product.css";
import { useNavigate } from "react-router-dom";

function ProductList() {
  const [products, setProducts] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [id, setId] = useState(null);
  const navigate = useNavigate();
  const [update, setUpdated] = useState(true);

  useEffect(() => {
    const fetchProducts = async () => {
      try {
        const response = await axios.get("/api/v1/getProducts");
        setProducts(response.data);
        setLoading(false);
      } catch (error) {
        setError(error.message);
        setLoading(false);
      }
    };

    fetchProducts();
  }, []);

  const deleteProduct = async (index) => {
    try {
      const response = await axios.delete(
        `/api/v1/deleteProductById/${products[index].id}`
      );
      setProducts((prevProducts) => {
        // Create a copy of the previous state array
        const updatedProducts = [...prevProducts];
        updatedProducts.splice(index, 1);
        return updatedProducts;
      });
    } catch (error) {
      console.log(error);
    }
  };
  const updateForm = (id) => {
    setId(id);
    navigate(`/product`, { state: { id: id, update: update } });
  };
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
              <td>
                <button onClick={() => deleteProduct(index)} id="remove-btn">
                  Remove
                </button>
              </td>
              <td>
                {/* <Link
                  to={{
                    pathname: "/product",
                    state: { id: products[index].id, update: update },
                  }}
                > */}
                <button
                  onClick={() => updateForm(products[index].id)}
                  id="edit-btn"
                >
                  Update
                </button>
                {/* </Link> */}
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default ProductList;
