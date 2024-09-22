import React from "react";
import CarouselPage from "../components/CarouselPage";
import img1 from "../img/beef.jpg";
import img3 from "../img/ittime.jpg";
import img2 from "../img/us.jpg";
import "../styles/HomePage.css";

function Home() {
  return (
    <>
      <CarouselPage />
      <div className="container container-custom mt-5">
        <div className="row">
          {/* Column 1 */}
          <div className="col-md-6 column-1">
            <h1>DINE WITH US</h1>
            <img src={img1} alt="Dining" className="img-fluid mb-3" />
            <p>Description about the dining experience.</p>
            <a href="/menu" className="btn-custom">
              SEE THE MENU
            </a>
          </div>

          {/* Column 2 */}
          <div className="col-md-6 column-2">
            <h1>
              DISCOVER ABOUT <br />
              OUR RESTAURANT
            </h1>
            <img src={img2} alt="Restaurant" className="img-fluid mb-3" />
            <p>Description about the restaurant.</p>
            <a href="/about" className="btn-custom">
              LEARN MORE
            </a>
          </div>
        </div>
      </div>

      <div className="new-section">
        <div className="text-center">
          <h2 className="section-title">HARASY</h2>
        </div>
        <div className="row">
          {/* Column 1 */}
          <div className="col-md-6">
            <img src={img3} alt="Opening" className="img-fluid mb-3 new-img" />
          </div>

          {/* Column 2 */}
          <div className="col-md-6">
            <p className="new-description">
              Here is a description about the opening of Hell's Kitchen and what
              to expect. This is a great place to get excited about the new
              venture and what it offers.
            </p>
            <a href="/openings" className="btn-custom">
              LEARN MORE
            </a>
          </div>
        </div>
      </div>
    </>
  );
}

export default Home;
