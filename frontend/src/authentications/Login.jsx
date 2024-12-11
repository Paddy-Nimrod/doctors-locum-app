import './credential.css';
// eslint-disable-next-line no-unused-vars
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

import 'boxicons/css/boxicons.min.css';

function Login() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  const handleLogin = (e) => {
    e.preventDefault();
    if (email === "admin@gmail.com") {
      navigate("/dashboard");
    } else if (email === "doctor@gmail.com") {
      navigate("/doctor");
    } else {
      alert("Invalid credentials");
    }
  };

  return (
    <main className='login-main'>
      <article id="login-section" className="login" aria-labelledby="">
        <div role="status" aria-live="polite" className="alert-message error">
          <h1>Username already registered</h1>
          <button className="alert-close">
            <svg id="close-alert" xmlns="http://www.w3.org/2000/svg" viewBox="0 -960 960 960" className="icon">
              <path d="m256-200-56-56 224-224-224-224 56-56 224 224 224-224 56 56-224 224 224 224-56 56-224-224-224 224Z" />
            </svg>
          </button>
        </div>

        <header className="form-header">Login</header>

        <form
          onSubmit={handleLogin}
          method="post"
          name="login-form"
          id="login-form"
          className="register-form"
        >
          <div className="form-group">
            <div className="password-wrapper">
              <input
                type="email"
                name="login-email"
                className="email"
                placeholder="Enter your email"
                aria-describedby="password-error password-strength"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
              />

              <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 -960 960 960" className="icon left">
                <path d="M160-160q-33 0-56.5-23.5T80-240v-480q0-33 23.5-56.5T160-800h640q33 0 56.5 23.5T880-720v480q0 33-23.5 56.5T800-160H160Zm320-280L160-640v400h640v-400L480-440Zm0-80 320-200H160l320 200ZM160-640v-80 480-400Z" />
              </svg>
            </div>
            <small className="email-error" role="alert"></small>
          </div>

          <div className="form-group">
            <div className="password-wrapper">
              <input
                type="password"
                id="login-password"
                className="password"
                placeholder="Enter your password"
                name="login-password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
              />

              <svg
                id="pass-icon"
                xmlns="http://www.w3.org/2000/svg"
                viewBox="0 -960 960 960"
                className="icon"
              >
                <path
                  id="icon-path"
                  d="M480-320q75 0 127.5-52.5T660-500q0-75-52.5-127.5T480-680q-75 0-127.5 52.5T300-500q0 75 52.5 127.5T480-320Zm0-72q-45 0-76.5-31.5T372-500q0-45 31.5-76.5T480-608q45 0 76.5 31.5T588-500q0 45-31.5 76.5T480-392Zm0 192q-146 0-266-81.5T40-500q54-137 174-218.5T480-800q146 0 266 81.5T920-500q-54 137-174 218.5T480-200Z"
                />
              </svg>

              <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 -960 960 960" className="icon left">
                <path
                  d="M240-80q-33 0-56.5-23.5T160-160v-400q0-33 23.5-56.5T240-640h40v-80q0-83 58.5-141.5T480-920q83 0 141.5 58.5T680-720v80h40q33 0 56.5 23.5T800-560v400q0 33-23.5 56.5T720-80H240Zm0-80h480v-400H240v400Zm240-120q33 0 56.5-23.5T560-360q0-33-23.5-56.5T480-440q-33 0-56.5 23.5T400-360q0 33 23.5 56.5T480-280ZM360-640h240v-80q0-50-35-85t-85-35q-50 0-85 35t-35 85v80ZM240-160v-400 400Z"
                />
              </svg>
            </div>
            <small id="log-pass-error" className="password-text" role="alert"></small>
          </div>

          <div className="checkbox">
            <div className="checkbox-content">
              <input name="logCheck" type="checkbox" id="logCheck" />
              <label htmlFor="logCheck" className="text">Remember me</label>
            </div>

            <a href="#" id="forgot-link" className="text">Forgot password?</a>
          </div>

          <footer className="login-action">
            <button type="submit" className="auth-button" id="login-btn" aria-label="Sign Up">
              Login
            </button>

            <nav>
              <span>Not a member?</span>
              <a href="#" id="register-link" className="signUp-link">Sign Up</a>
            </nav>
          </footer>
        </form>
      </article>
    </main>
  );
}

export default Login;


