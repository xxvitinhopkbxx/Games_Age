import React, { useState } from 'react'
import './Login.css'

const Login = () => {
  let [authMode, setAuthMode] = useState("signin")

  const changeAuthMode = () => {
    setAuthMode(authMode === "signin" ? "signup" : "signin")
  }

  if (authMode === "signin") {
    return (
      <div className="Auth-form-container">
        <form className="Auth-form">
          <div className="Auth-form-content">
            <h3 className="Auth-form-title">Sign In</h3>
            <div className="text-center">
              Not registered yet?{" "}
              <span className="link-primary" onClick={changeAuthMode}>
                Sign Up
              </span>
            </div>
            <div className="form-floating mt-3">
              <input
                type="email"
                id='email'
                className="form-control mt-1"
                placeholder="Email address"
              />
              <label htmlFor='email'>Email address</label>
            </div>
            <div className="form-floating mt-3">
              <input
                type="password"
                id='senha'
                className="form-control mt-1"
                placeholder="Password"
              />
              <label htmlFor='senha'>Password</label>
            </div>
            <div className="d-grid gap-2 mt-3">
              <button type="submit" className="btn btn-primary">
                Submit
              </button>
            </div>
            <p className="text-center mt-2">
              Forgot <a href="#">password?</a>
            </p>
          </div>
        </form>
      </div>
    )
  }

  return (
    <div className="Auth-form-container">
      <form className="Auth-form">
        <div className="Auth-form-content">
          <h3 className="Auth-form-title">Sign Up</h3>
          <div className="text-center">
            Already registered?{" "}
            <span className="link-primary" onClick={changeAuthMode}>
              Sign In
            </span>
          </div>
          <div className="form-floating mb-3">
            <input
              type="text"
              id='nome'
              className="form-control mt-1"
              placeholder="Full Name"
            />
            <label htmlFor='nome' >Full Name</label>
          </div>
          <div className="form-floating mb-3">
            <input
              type="email"
              id='emailcad'
              className="form-control mt-1"
              placeholder="Email address"
            />
            <label htmlFor='emailcad'>Email address</label>
          </div>
          <div className="form-floating mb-3">
            <input
              type="password"
              id='senhacad'
              className="form-control"
              placeholder="Password"
            />
            <label htmlFor='senhacad'>Password</label>
          </div>
          <div className="d-grid gap-2 mb-3">
            <button type="submit" className="btn btn-primary">
              Submit
            </button>
          </div>
        </div>
      </form>
    </div>
  )
}

export default Login