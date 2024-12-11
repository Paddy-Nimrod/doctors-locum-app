// eslint-disable-next-line no-unused-vars
import React from "react";
import Sidebar from "./components/Sidebar";
import Topbar from "./components/Topbar";
import MainSec from "./components/MainSec";

function Dashboard() {
  return (
    <div>
      <Sidebar />
      <Topbar />
      <MainSec/>
    </div>
  );
}

export default Dashboard;
