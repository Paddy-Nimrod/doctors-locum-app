// eslint-disable-next-line no-unused-vars
import { useState } from 'react'
// eslint-disable-next-line no-unused-vars
import reactLogo from './assets/react.svg'
// eslint-disable-next-line no-unused-vars
import viteLogo from '/vite.svg'
import './App.css'
import MainSec from './MainSec'
import Sidebar from './Sidebar'
import Topbar from './topbar'

function App() {

  return (
    <>
      <Sidebar/>
      <Topbar/>
      <MainSec/>
    </>
  )
}

export default App
