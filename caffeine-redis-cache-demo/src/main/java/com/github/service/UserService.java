/*
 * .............................................
 *
 * 				    _ooOoo_
 * 		  	       o8888888o
 * 	  	  	       88" . "88
 *                 (| -_- |)
 *                  O\ = /O
 *              ____/`---*\____
 *               . * \\| |// `.
 *             / \\||| : |||// \
 *           / _||||| -:- |||||- \
 *             | | \\\ - /// | |
 *            | \_| **\---/** | |
 *           \  .-\__ `-` ___/-. /
 *            ___`. .* /--.--\ `. . __
 *        ."" *< `.___\_<|>_/___.* >*"".
 *      | | : `- \`.;`\ _ /`;.`/ - ` : | |
 *         \ \ `-. \_ __\ /__ _/ .-` / /
 *======`-.____`-.___\_____/___.-`____.-*======
 *
 * .............................................
 *              佛祖保佑 永无BUG
 *
 * 佛曰:
 * 写字楼里写字间，写字间里程序员；
 * 程序人员写程序，又拿程序换酒钱。
 * 酒醒只在网上坐，酒醉还来网下眠；
 * 酒醉酒醒日复日，网上网下年复年。
 * 但愿老死电脑间，不愿鞠躬老板前；
 * 奔驰宝马贵者趣，公交自行程序员。
 * 别人笑我忒疯癫，我笑自己命太贱；
 * 不见满街漂亮妹，哪个归得程序员？
 *
 * 北纬30.√  154518484@qq.com
 */
package com.github.service;

import com.github.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
public class UserService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/** 添加 */
	@CachePut(value="objectCache", key="(#root.targetClass.getSimpleName()).concat(':id:').concat(#user.id)")
	public User add(User user) {
		// 特别注意: 这里 SpEL #user.id  入参user 和 反馈对象user 要 == SpEL才能取到值

		logger.info("add...");
		user.setId(1);
		return user;
	}
	/** 删除 */
	@CacheEvict(value="objectCache", key="(#root.targetClass.getSimpleName()).concat(':id:').concat(#id)")
	public void delete(Integer id) {
		logger.info("delete...");
	}
	/** 修改 */
	@CachePut(value="objectCache", key="(#root.targetClass.getSimpleName()).concat(':id:').concat(#user.id)")
	public User update(User user) {
		logger.info("update...");
		return new User(1, "成都update");
	}
	/** 查看 - 从Cache中获取对象 */
	@Cacheable(value="objectCache", key="(#root.targetClass.getSimpleName()).concat(':id:').concat(#id)", unless="#result eq null")
	public User get(Integer id) {
		logger.info("get...");
		return new User(id, "成都get");
	}

	@Cacheable(value="objectCache", key="(#root.targetClass.getSimpleName()).concat(':id:').concat(#id)", unless="#result eq null")
	public User getNull(Integer id) {
		// unless="#result eq null"  设置不缓存null, 这里会造成缓存穿透
		logger.info("getNull...");
		return null;
	}
}

