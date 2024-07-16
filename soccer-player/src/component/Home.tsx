import React from "react";
import { Link } from "react-router-dom";
import "../css/Home.css"; // 스타일을 위한 CSS 파일 임포트

const Home = () => {
  return (
    <div className="home-container">
      <h1>Welcome to Soccer Community</h1>
      <div className="button-container">
        <Link to="/login" className="home-button">
          Login
        </Link>
        <Link to="/signup" className="home-button">
          Signup
        </Link>
      </div>
    </div>
  );
};

export default Home;
