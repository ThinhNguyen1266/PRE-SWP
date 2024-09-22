import "bootstrap/dist/css/bootstrap.min.css";
import React from "react";
import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import Offcanvas from "react-bootstrap/Offcanvas";
import { Link } from "react-router-dom";
import logo from "../assets/img/logo.png";
import "../assets/styles/Nav.css";

function NavigationBar() {
  return (
    <>
      {["sm"].map((expand) => (
        <Navbar key={expand} expand={expand} className="custom-navbar mb-3">
          <Container fluid>
            <Link to="/" className="navbar-brand">
              <img
                src={logo}
                alt="Logo"
                width="140"
                className="d-inline-block align-top"
              />
            </Link>
            <Navbar.Toggle aria-controls={`offcanvasNavbar-expand-${expand}`} />
            <Navbar.Offcanvas
              id={`offcanvasNavbar-expand-${expand}`}
              aria-labelledby={`offcanvasNavbarLabel-expand-${expand}`}
              placement="end"
            >
              <Offcanvas.Header closeButton>
                <Offcanvas.Title id={`offcanvasNavbarLabel-expand-${expand}`}>
                  Offcanvas
                </Offcanvas.Title>
              </Offcanvas.Header>
              <Offcanvas.Body>
                <Nav className="justify-content-center flex-grow-1 pe-3">
                  <Link to="/venues" className="nav-link">
                    VENUES
                  </Link>
                  <Link to="/menu" className="nav-link">
                    MENU
                  </Link>
                  <Link to="/contacts" className="nav-link">
                    CONTACTS
                  </Link>
                  <Link to="/contacts" className="nav-link">
                    ABOUT US
                  </Link>
                </Nav>
                <Nav className="justify-content-end pe-3">
                  <Link to="/login" className="login-button">
                    BOOK
                  </Link>
                </Nav>
              </Offcanvas.Body>
            </Navbar.Offcanvas>
          </Container>
        </Navbar>
      ))}
    </>
  );
}
export default NavigationBar;
