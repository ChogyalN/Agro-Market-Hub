import Header from "./components/Header";
import Product from "./components/Product";
import ProductList from "./components/ProductList";
import Registration from "./components/Registration";

function App() {
  return (
    <div className="App">
      <Header />
      {/* <Registration /> */}
      <Product />
      <ProductList />
    </div>
  );
}

export default App;
