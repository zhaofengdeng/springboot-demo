package com.project.controller.ebean;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.User;
import com.project.model.UserDetail;

import io.ebean.Ebean;
import io.ebean.Expr;
import io.ebean.Expression;
import io.ebean.ExpressionList;
import io.ebean.Query;
import io.ebean.Transaction;

/**
 * 
 * @author Administrator
 *
 */
@RestController
@RequestMapping(value = "/ebean_base", method = { RequestMethod.POST, RequestMethod.GET })
public class EbeanBaseController {
	// 测试连接
	// save?name=zhaofengdeng&no=12
	@RequestMapping(value = "/save")
	public User save(HttpServletRequest request) {
		String name = request.getParameter("name");
		String no = request.getParameter("no");
		User user = new User();
		user.setName(name);
		user.setNo(no);
		user.save();
		return user;
	}

	// update?id=1&name=zhaofengdeng2&no=124
	@RequestMapping(value = "/update")
	public User update(HttpServletRequest request) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String no = request.getParameter("no");
		ExpressionList<User> el = Ebean.find(User.class).where().eq("deleted", false);
		User user = el.eq("id", id).findOne();
		user.setName(name);
		user.setNo(no);
		user.update();
		return user;
	}

	@RequestMapping(value = "/search")
	public List<User> search(HttpServletRequest request) {
		ExpressionList<User> el = Ebean.find(User.class).where().eq("deleted", false);
		List<User> users = el.orderBy("insertedAt desc").findList();
		return users;
	}

	public List<User> search() {
		ExpressionList<User> el = Ebean.find(User.class).where();
		// 模糊查询带a
		el.like("name", "%a%");
		// 查询type等于abc
		el.eq("type", "abc");
		// 查询sex等于男或者等于女的
		Expression el1 = Expr.eq("sex", "男");
		Expression el2 = Expr.eq("sex", "女");
		el.or(el1, el2);

		// in使用list
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		el.in("id", list);

		// in使用sql
		Query<UserDetail> queryin = Ebean.find(UserDetail.class).select("userId").where().eq("name", "O2活动").query();
		el.in("id", queryin);
		// 分页
		Query<User> query = el.setFirstRow(10).setMaxRows(15);
		return query.findList();
	}

	public void process(User user) {

		Transaction transaction = Ebean.beginTransaction();
		try {
			Ebean.delete(user);
			Ebean.save(user);
			Ebean.update(user);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		transaction.end();

	}

}
