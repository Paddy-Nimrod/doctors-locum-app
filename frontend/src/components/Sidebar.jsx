// eslint-disable-next-line no-unused-vars
import React, { useEffect } from "react";
// import React from "react"
import  "./App.css"
import 'boxicons/css/boxicons.min.css';


function Sidebar() {
    useEffect(() => {
        const toggleButton = document.querySelector(".toggle");
        const sidebar = document.querySelector(".sidebar");

        const toggleSidebar = () => {
            sidebar.classList.toggle("close");
        };

        toggleButton.addEventListener("click", toggleSidebar);
        
        return () => {
            toggleButton.removeEventListener("click", toggleSidebar);
        };
    }, []);


    return(
       <aside className="sidebar close">
            <header>
                <div className="logo-box">
                    <span className="image">
                        <i className='bx bx-plus-medical logo'></i>
                    </span>

                    <div className="company header-text">
                        <span className="name">DAKTARI</span>
                        <span className="profession">Locum App</span>
                    </div>
                </div>

                <i className="bx bx-chevron-right toggle"></i>
            </header>

            <nav className="menu-bar">
                <div className="menu">
                    <ul className="menu-links">

                        <li className="nav-link">
                            <a href="#"  className="active">
                                <i className='bx bx-time-five icon'></i>
                                <span className="text nav-text">Shifts</span>
                            </a>
                        </li>

                        <li className="nav-link">
                            <a href="#">
                                <i className='bx bxs-hourglass-bottom icon'></i>
                                <span className="text nav-text">Appointments</span>
                            </a>
                        </li>

                        <li className="nav-link">
                            <a href="#">
                                <i className='bx bxs-report icon'></i>
                                <span className="text nav-text">Lab Results</span>
                            </a>
                        </li>

                        <li className="nav-link">
                            <a href="#">
                                <i className='bx bx-wallet icon'></i>
                                <span className="text nav-text"> Payments</span>
                            </a>
                        </li>

                        <li className="nav-link">
                            <a href="#">
                                <i className='bx bx-log-out-circle icon'></i>
                                <span className="text nav-text">Leave</span>
                            </a>
                        </li>

                        <li className="nav-link">
                            <a href=" #">
                                <i className="bx bx-pie-chart-alt icon"></i>
                                <span className="text nav-text">Analytics</span>
                                <i className='bx bx-chevron-down icon arrow'></i>
                            </a>

                            <ul className="sub-menu">
                                <li><a href=""><span className="text">Daily</span></a></li>
                                <li><a href=""><span className="text">monthly</span></a></li>
                                <li><a href=""><span className="text">Annually</span></a></li>
                            </ul>
                        </li>

                        

                    </ul>
                </div>


                <div className="bottom-content">
                    <li className="nav-link">
                        <a href="#">
                            <i className='bx bx-cog icon'></i>
                            <span className="text nav-text">Settings</span>
                        </a>
                    </li>
                </div>
            </nav>

       </aside>
    )
    
}

export default Sidebar
