import React, { useState } from 'react';
import styles from './Signup.module.css'; // You can rename or split styles later
import { Link, useNavigate } from 'react-router-dom';

function Login() {
  const [form, setForm] = useState({ username: '', password: '' });
  const navigate = useNavigate();

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await fetch('http://localhost:8080/login', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(form),
      });

      const data = await response.json();
      console.log(data); // TEMP: Log the token

      if (response.ok) {
        localStorage.setItem('token', data.message); // Store JWT
        navigate('/dashboard'); // Auto-redirect to dashboard
      } else {
        alert('Login failed. Please check your credentials.');
      }
    } catch (err) {
      console.error('Login error:', err);
      alert('Something went wrong. Please try again.');
    }
  };

  return (
    <div className={styles.container}>
      <h1>Login</h1>
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
        <button className={styles.button} type="submit">Login</button>
      </form>
      <p>Don't have an account? <Link to="/signup">Sign up</Link></p>
    </div>
  );
}

export default Login;
