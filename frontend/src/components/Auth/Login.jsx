import React from 'react';
import { Link } from 'react-router-dom';
import styles from './Login.module.css';

function Login() {
  return (
    <div className={styles.container}>
      <h1>Login</h1>
      <input className={styles.input} type="text" placeholder="Username" />
      <input className={styles.input} type="password" placeholder="Password" />
      <button className={styles.button}>Log In</button>
      
      <p>Don't have an account? <Link to="/signup">Sign up</Link></p>
    </div>
  );
}

export default Login;
