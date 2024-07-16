import React from "react";
import { Formik, Form, Field, ErrorMessage } from "formik";
import * as Yup from "yup";
import "../css/Login.css"; // 스타일 시트 임포트

interface LoginValues {
  email: string;
  password: string;
}

const initialValues: LoginValues = {
  email: "",
  password: "",
};

const loginSchema = Yup.object().shape({
  email: Yup.string().email("Invalid email").required("Email is required"),
  password: Yup.string().required("Password is required"),
});

export const Login = () => {
  const handleLogin = (values: LoginValues) => {
    // API call to login the user
    console.log(values);
  };

  return (
    <div className="login-container">
      <div className="overlay">
        <h1>Login</h1>
        <Formik
          initialValues={initialValues}
          validationSchema={loginSchema}
          onSubmit={handleLogin}
        >
          {({ isSubmitting }) => (
            <Form className="login-form">
              <div className="form-group">
                <Field
                  type="email"
                  name="email"
                  placeholder="Email"
                  className="input-field"
                />
                <ErrorMessage
                  name="email"
                  component="div"
                  className="error-message"
                />
              </div>

              <div className="form-group">
                <Field
                  type="password"
                  name="password"
                  placeholder="Password"
                  className="input-field"
                />
                <ErrorMessage
                  name="password"
                  component="div"
                  className="error-message"
                />
              </div>

              <button
                type="submit"
                className="submit-button"
                disabled={isSubmitting}
              >
                Login
              </button>
            </Form>
          )}
        </Formik>
      </div>
    </div>
  );
};
