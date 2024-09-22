import "bootstrap/dist/css/bootstrap.min.css";
import React, { useState } from "react";
import Carousel from "react-bootstrap/Carousel";
import img1 from "../img/bg.jpg";
import "../styles/Carousel.css";

function CarouselPage() {
  const [index, setIndex] = useState(0);

  const handleSelect = (selectedIndex) => {
    setIndex(selectedIndex);
  };

  return (
    <Carousel activeIndex={index} onSelect={handleSelect}>
      <Carousel.Item>
        <img
          className="carousel-img d-block w-100"
          src={img1}
          alt="First slide"
        />
        <Carousel.Caption className="carousel-caption-custom">
          <h3>
            Welcome to <br />
            Harasy
          </h3>
          <p>
            World-renowned Michelin-starred Chef Gordon Ramsay's iconic
            <br />
            Hell's Kitchen is now open in Miami.
          </p>
          <button className="btn-custom">MAKE A RESERVATION</button>
        </Carousel.Caption>
      </Carousel.Item>
      <Carousel.Item>
        <img
          className="carousel-img d-block w-100"
          src={img1}
          alt="Second slide"
        />
        <Carousel.Caption className="carousel-caption-custom">
          <h3>
            OUR <br />
            SIGNATURE <br />
            DISHES
          </h3>
          <p>
            Experience our classic Beef Wellington, Lobster Risotto
            <br />
            and more
          </p>
          <button className="btn-custom">SEE THE MENU</button>
        </Carousel.Caption>
      </Carousel.Item>
      <Carousel.Item>
        <img
          className="carousel-img d-block w-100"
          src={img1}
          alt="Thirst slide"
        />
        <Carousel.Caption className="carousel-caption-custom">
          <h3>
            HARASY <br />
            CLUB
          </h3>
          <p>
            Join the Harasy E-Club and be the first to learn about
            <br />
            local events, seasonal menu offerings, and more
          </p>
          <button className="btn-custom">LOG IN</button>
        </Carousel.Caption>
      </Carousel.Item>
    </Carousel>
  );
}

export default CarouselPage;
