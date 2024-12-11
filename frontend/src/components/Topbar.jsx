// eslint-disable-next-line no-unused-vars
import React from "react"
import  "./App.css"
import 'boxicons/css/boxicons.min.css';

function Topbar() {
    return(
        <header className="top-bar">
            <ol className="breadcrumb">
                <li className="breadcrumb-item">Dashboard</li>
                <li className="breadcrumb-item active" aria-current="page">Dashboard</li>
            </ol>

            <nav className="nav">
                <button className="theme-toggle" aria-label="Toggle theme" type="button">
                    <i id="lights" className="bx bx-moon"></i>
                </button>

                <div className="notifications">
                <button className="notifications-trigger" aria-label="View notifications" type="button">
                    <i className="bx bxs-bell"></i>
                    <span className="badge">4</span>
                </button>

                <div className="alerts-panel" hidden>
                    <header>ALERTS CENTER</header>
                    <ul className="alerts-list">
                        <li className="alert">
                            <i className="bx bx-file blue"></i>
                            <div>
                                <time>December 12, 2019</time>
                                <p>A new monthly report is ready to download!</p>
                            </div>
                        </li>
                        <li className="alert">
                            <i className="bx bx-user green"></i>
                            <div>
                                <time>December 7, 2019</time>
                                <p>$290.29 has been deposited into your account!</p>
                            </div>
                        </li>
                        <li className="alert">
                            <i className="bx bx-error yellow"></i>
                            <div>
                                <time >December 2, 2019</time>
                                <p>Spending Alert: We have noticed unusually high spending for your account.</p>
                            </div>
                        </li>
                    </ul>
                    <button className="show-all" type="button">Show All Alerts</button>
                </div>
            </div>

                <div className="user">
                    <button className="user-trigger" type="button">
                        <span className="avatar">M</span>
                        <div className="user-info">
                            <span>Farida Mutwa</span>
                            <span>Hospital Staff</span>
                        </div>
                        <i className="bx bx-chevron-down"></i>
                    </button>

                    <ul className="user-menu" hidden>
                        <li><a href="#profile"><i className="bx bx-user"></i>Profile</a></li>
                        <li><a href="#activity"><i className="bx bx-history"></i>Activity Log</a></li>
                        <li><a href="#logout"><i className="bx bx-log-out"></i>Logout</a></li>
                    </ul>
                </div>

            </nav>
        </header>
    )
}

export default Topbar
