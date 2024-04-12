import React from "react";
import "../css/landing.css";
import PieChartComponent from "./pieChart.js";

function Landing() {
  return (
    <>
      <section class="parallax-section">
        <div class="parallax-bg bg1"></div>
        <div class="parallax-bg bg2"></div>
        <div class="content">
          <h2>Empowering Farmers, Connecting Markets</h2>
          <p>
            Welcome to Bhutan FarmConnect, your one-stop solution for empowering
            farmers and connecting them with markets.
          </p>
        </div>
      </section>
      <section class="historical-background">
        <div class="container-01">
          <h2>Historical Background</h2>
          <p>
            Farming in Bhutan has a rich historical heritage, deeply intertwined
            with the country's culture and economy. For centuries, agriculture
            has been the primary livelihood for Bhutanese communities,
            sustaining families and shaping rural life. Traditional farming
            practices, passed down through generations, emphasized
            sustainability and harmony with nature.
          </p>

          <p>
            In the mid-20th century, Bhutan embarked on a journey of
            modernization, which included advancements in agricultural
            techniques and infrastructure development. Recognizing the
            importance of agriculture, the government implemented policies to
            support farmers, enhance productivity, and promote sustainable
            farming practices.
          </p>

          <p>
            Today, agriculture remains a cornerstone of Bhutan's economy,
            employing a significant portion of the population and contributing
            to food security and rural development. Bhutan's commitment to
            organic farming and environmental conservation continues to shape
            agricultural practices, ensuring a sustainable future for
            generations to come.
          </p>
        </div>
      </section>

      <section id="services">
        <h2>Features & Services</h2>
        <div class="container03">
          <div class="service">
            <img
              src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQrLmjejEprdlFrMdBPwBb_ZHMOQC2Gvc2NDltgxjc3_A&s"
              alt="Online Marketplace"
            />
            <div>
              <h3>Online Marketplace</h3>
              <p>
                Connect farmers with buyers through an easy-to-use online
                marketplace.
              </p>
            </div>
          </div>
          <div class="service">
            <img
              src="https://cdn.iconscout.com/icon/premium/png-256-thumb/market-research-71-991113.png"
              alt="Market Information"
            />
            <div>
              <h3>Market Information</h3>
              <p>
                Provide farmers with valuable market information to help them
                make informed decisions.
              </p>
            </div>
          </div>
          <div class="service">
            <img
              src="https://static.thenounproject.com/png/1106292-200.png"
              alt="Payment Integration"
            />
            <div>
              <h3>Payment Integration</h3>
              <p>
                Facilitate secure transactions with integrated payment options.
              </p>
            </div>
          </div>
          <div class="service">
            <img
              src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQXdjpFCUop1kaFqTob80xuGmnfFAUGLPUkzav50X_ibg&s"
              alt="Farmer Support"
            />
            <div id="last">
              <h3>Farmer Support</h3>
              <p>
                Offer support and resources to farmers, including training and
                technical assistance.
              </p>
            </div>
          </div>
        </div>
      </section>
      <section class="beautiful-section">
        <div class="content">
          <h2>Welcome to Our Beautiful Section</h2>
          <p>Discover the beauty around you.</p>
          <a href="#" class="btn">
            Explore
          </a>
        </div>
      </section>
      <h1>Pie Chart </h1>

      <div class="pie-chart">
        <PieChartComponent />
      </div>
    </>
  );
}

export default Landing;
