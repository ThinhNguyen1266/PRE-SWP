import React, { useState } from "react";
import { Link } from "react-router-dom";
import "../styles/Login.css";

function Login() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  return (
    <div className="container d-flex justify-content-center align-items-center vh-100">
      <div className="row w-100">
        <div className="col-md-4 offset-md-4">
          <form className="login-container">
            <div className="form-group">
              <label htmlFor="username">
                EMAIL<span className="required">*</span>
              </label>
              <input
                type="text"
                className="custom-input"
                value={username}
                onChange={(event) => setUsername(event.target.value)}
              />
            </div>

            <div className="form-group">
              <label htmlFor="password">
                PASSWORD<span className="required">*</span>
              </label>
              <input
                type="password"
                className="custom-input"
                value={password}
                onChange={(event) => setPassword(event.target.value)}
              />
            </div>

            <div className="text-start mb-3">
              <a href="/forgot-password" className="link">
                Forgot your password?
              </a>
            </div>

            <button type="submit" className="custom-button">
              Log In
            </button>

            <div className="text-center mt-3">
              <span>Need an account? </span>
              <Link to="/register" className="link register-link">
                Register
              </Link>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
}

export default Login;
