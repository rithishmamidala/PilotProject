import React from 'react';
import './SideBar.css';

const Sidebar = () => {
    return (
        <div className="sidebar">
            <div className="username">User Name</div>
            <div className="menu">
                <div className="menu-item">Dashboard</div>
                <div className="menu-item">Create Assessment</div>
                <div className="menu-item">Access Management</div>
            </div>
        </div>
    );
};

export default Sidebar;
