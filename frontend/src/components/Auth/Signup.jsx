import React from 'react';
import { Link } from "react-router-dom";
import styles from './Signup.module.css';


function Signup() {
  return (
    <div className={styles.container}>
      <h1>Signup</h1>
      <input className={styles.input} type="text" placeholder="Username" />
      <input className={styles.input} type="password" placeholder="Password" />
      <button className={styles.button}>Signup</button>

 
<p>Already have an account? <Link to="/">Log in</Link></p>
    </div>
  );
}






export default Signup;
