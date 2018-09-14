package fr.dawan.reseauSoc.servlet.movie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import fr.dawan.reseauSoc.beans.Movie;
import fr.dawan.reseauSoc.bo.MovieBo;
import fr.dawan.reseauSoc.dao.Dao;

@WebServlet("/movie")
public class ViewMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewMovieServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		int id= 0;
		request.setAttribute("error", true);
		request.setAttribute("titlePage", "film inconnue");
		
		if(request.getParameter("id") != null) {
			try {
				id= Integer.valueOf(request.getParameter("id"));	
			} catch (Exception e) {
				
			}
			
			Movie movie= MovieBo.findById(id);
			if(movie != null) {
				request.setAttribute("error", false);
				request.setAttribute("movie", movie);
				request.setAttribute("titlePage", movie.getTitle());	
			}
		}
		
		request.setAttribute("page", "/WEB-INF/movie/ViewMovie.jsp");
		request.getRequestDispatcher("/Index.jsp").forward(request, response);
	}
}