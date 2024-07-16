import React from "react";
import { Formik, Form, Field, ErrorMessage } from "formik";
import * as Yup from "yup";
import "../css/Signup.css"; // 스타일 시트 임포트

interface SignupValues {
  username: string;
  email: string;
  password: string;
}

const initialValues: SignupValues = {
  username: "",
  email: "",
  password: "",
};

const signupSchema = Yup.object().shape({
  username: Yup.string().required("Username is required"),
  email: Yup.string().email("Invalid email").required("Email is required"),
  password: Yup.string()
    .required("Password is required")
    .min(8, "Password must be at least 8 characters long"),
});

const Signup = () => {
  const handleSignup = (values: SignupValues) => {
    // API call to signup the user
    console.log(values);
  };

  return (
    <div className="signup-container">
      <div className="overlay">
        <h1>Sign Up</h1>
        <Formik
          initialValues={initialValues}
          validationSchema={signupSchema}
          onSubmit={handleSignup}
        >
          {({ isSubmitting }) => (
            <Form className="signup-form">
              <div className="form-group">
                <Field
                  type="text"
                  name="username"
                  placeholder="Username"
                  className="input-field"
                />
                <ErrorMessage
                  name="username"
                  component="div"
                  className="error-message"
                />
              </div>

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
                Sign Up
              </button>
            </Form>
          )}
        </Formik>
      </div>
    </div>
  );
};

export default Signup;
