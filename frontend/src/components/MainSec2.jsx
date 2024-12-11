// eslint-disable-next-line no-unused-vars
import React from "react"
import  "./App.css"


function MainSec() {
    return(
        <main className="home">
                <section className="all-users">

                    <div className="success-container">
                        <div className="success-icon">
                            <i className='bx bx-check'></i>
                        </div>
                        <div className="success-message">Success! Record deleted successfully.</div>
                        <button className="close-button">
                            <i className='bx bx-x remove-success'></i>
                        </button>
                    </div>

                    <header className="header">
                        <div className="header-tabs">
                            <a href="#" className="header-tab active">New Shifts</a>
                            <a href="#" className="header-tab">Assigned Shifts</a>
                            <a href="#" className="header-tab">All Shifts</a>
                        </div>
                    </header>
                    
                    <div className="table-container">
                        <div className="member-management">
                            <div className="search-box">
                                <i className='bx bx-search'></i>
                                <input type="text" className="search-input" placeholder="Search members..."/>
                            </div>
                            <button className="add-new-btn">
                                <i className='bx bx-plus'></i>
                                Add new shift
                            </button>
                        </div>

                        <table>
                            <thead>
                                <tr>
                                    <th>ShiftID</th>
                                    <th>Date</th>
                                    <th>Time</th>
                                    <th>Department</th>
                                    <th>Role</th>
                                    <th>Assignment</th>
                                    <th>Operation</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>
                                        <div className="user-id">001</div>
                                    </td>
                                    <td>2024-12-11</td>
                                    <td>08:00-16:00</td>
                                    <td>Radiology</td>
                                    <td>Doctor</td>
                                    <td><span className="status">Today</span></td>
                                    <td>
                                        <div className="operations">
                                            <i className='bx bx-trash operation-icon delete' title="Delete"></i>
                                            <i className='bx bx-show operation-icon view' title="View"></i> 
                                            <i className='bx bx-edit-alt operation-icon edit' title="Edit"></i>
                                        </div>
                                    </td>
                                    <td>
                                        <button className="login-btn">Accept</button>
                                    </td>
                                </tr>

                            </tbody>
                        </table>

                        
                        <div className="pagination">
                            <div className="pagination-info">
                                Showing 1 to 10 of 57 entries
                            </div>
                            <div className="pagination-controls">
                                <button className="page-btn">Previous</button>
                                <button className="page-btn active">1</button>
                                <button className="page-btn">2</button>
                                <button className="page-btn">3</button>
                                <button className="page-btn">4</button>
                                <button className="page-btn">5</button>
                                <button className="page-btn">6</button>
                                <button className="page-btn">Next</button>
                            </div>
                        </div>
                    </div>
                </section>
        </main>
    )
}

export default MainSec
