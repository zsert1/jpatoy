import React from "react";
import { Link } from "react-router-dom";
import "../css/Home.css"; // 스타일 시트 임포트

const Home = () => {
  return (
    <div className="home-container">
      <div className="overlay">
        <h1>Welcome to Soccer War Community</h1>
        <p>Join the battlefield of soccer and war!</p>
        <div className="button-container">
          <Link to="/login" className="home-button">
            Login
          </Link>
          <Link to="/signup" className="home-button">
            Signup
          </Link>
        </div>
      </div>
    </div>
  );
};

export default Home;
