import React, { useState } from 'react';
import styles from './Signup.module.css';
import { Link, useNavigate } from 'react-router-dom';

function Signup() {
  const [form, setForm] = useState({ username: '', password: '' });
  const navigate = useNavigate();

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await fetch('http://localhost:8080/signup', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(form),
      });

      const text = await response.text(); // could be plain text or error

      if (response.ok) {
        alert('Signup successful!');
        navigate('/account-setup'); // Redirect after successful signup
      } else if (text.includes("already taken")) {
        alert('Username is already taken. Please choose another.');
      } else {
        alert('Signup failed. Please try again.');
      }
    } catch (error) {
      console.error('Signup error:', error);
      alert('An error occurred. Please try again.');
    }
  };

  return (
    <div className={styles.container}>
      <h1>Signup</h1>
      <form onSubmit={handleSubmit}>
        <input
          name="username"
          className={styles.input}
          type="text"
          placeholder="Username"
          value={form.username}
          onChange={handleChange}
        />
        <input
          name="password"
          className={styles.input}
          type="password"
          placeholder="Password"
          value={form.password}
          onChange={handleChange}
        />
        <button className={styles.button} type="submit">Signup</button>
      </form>
      <p>Already have an account? <Link to="/">Log in</Link></p>
    </div>
  );
}

export default Signup;
