import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App'

// Render the main App component into the root div in index.html
ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
)
