package fr.dawan.reseauSoc.like;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dawan.reseauSoc.beans.Category;
import fr.dawan.reseauSoc.beans.Likable;
import fr.dawan.reseauSoc.beans.LikeDislike;
import fr.dawan.reseauSoc.beans.Movie;
import fr.dawan.reseauSoc.beans.PeopleContent;
import fr.dawan.reseauSoc.beans.User;
import fr.dawan.reseauSoc.dao.Dao;
import fr.dawan.reseauSoc.movie.MovieBo;
import fr.dawan.reseauSoc.mur.MurBo;

@WebServlet("/like")
public class LikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LikeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id= 0;
		
		if(request.getParameter("like").equals("1") || request.getParameter("like").equals("-1")) {
			User user= (User) request.getSession().getAttribute("user");
			
			Likable likable;
			LikeDislike like = null;
			try {
				id= Integer.valueOf(request.getParameter("id"));
				EntityManager em1= Dao.createEntityManager("JPA");
				likable= Dao.findById(Likable.class, id, em1);
				Dao.close(em1);
			} catch (Exception e) {
				response.sendError(400, "L'id n'est pas cohérent");
				return;
			}
			

			int vote= Integer.valueOf(request.getParameter("like"));
			like= new LikeDislike(user, likable, vote);
			
			switch (request.getParameter("type")) {
			case "movie":
				if(LikeBo.save(like)) {
					like.setType("movie");
					MurBo mBo= new MurBo();
					EntityManager em= Dao.createEntityManager("JPA");
					Movie movie= MovieBo.findById(Movie.class, likable.getId(), em);
					mBo.setMovie(movie, user, like);
					Dao.close(em);
				}
				response.sendRedirect(request.getContextPath()+"/movie?id="+id);
				return;
			case "category":
				if(LikeBo.save(like)) {
					like.setType("category");
					MurBo mBo= new MurBo();
					EntityManager em= Dao.createEntityManager("JPA");
					Category category= Dao.findById(Category.class, likable.getId(), em);
					Dao.close(em);
					mBo.setCategory(category, user, like);
				}
				response.sendRedirect(request.getContextPath()+"/category?id="+id);
				return;
			case "user":
				if(LikeBo.save(like)) {
					like.setType("user");
					MurBo mBo= new MurBo();
					EntityManager em= Dao.createEntityManager("JPA");
					User searchedUser= Dao.findById(User.class, likable.getId(), em);
					Dao.close(em);
					mBo.setUser(searchedUser, user, like);
				}
				response.sendRedirect(request.getContextPath()+"/user?id="+id);
				return;
			case "people":
				if(LikeBo.save(like)) {
					like.setType("people");
					MurBo mBo= new MurBo();
					EntityManager em= Dao.createEntityManager("JPA");
					PeopleContent people= Dao.findById(PeopleContent.class, likable.getId(), em);
					Dao.close(em);
					mBo.setPeopleContent(people, user, like);
				}
				response.sendRedirect(request.getContextPath()+"/people?id="+id);
				return;
			default:
				break;
			}
		}else {
			response.sendError(403, "Le type de contenu n'est pas cohérent!");
			return;
		}
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}