<header>
    <h1><span>XXX</span></h1>
    <nav>
        <ul>
            <li ${param.page eq 'Index'?'id="actual"':""}><a href="Servlet?command=Index">Home</a></li>
            <li ${param.page eq 'PersonOverview'?'id="actual"':""}><a href="Servlet?command=PersonOverview">Overview</a>
            </li>
            <li ${param.page eq 'Register'?'id="actual"':""}><a href="Servlet?command=Register">Register</a></li>
        </ul>
    </nav>
    <h2>${param.page}</h2>
</header>