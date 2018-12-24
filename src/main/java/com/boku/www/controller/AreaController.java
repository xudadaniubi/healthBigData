package com.boku.www.controller;
import java.util.List;

import com.boku.www.pojo.TArea;
import com.boku.www.utils.CurrentUser;
import com.boku.www.utils.PageResult;
import com.boku.www.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.boku.www.service.AreaService;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/area")
@CrossOrigin//解决跨域问题
public class AreaController {
	private static Logger logger = LoggerFactory.getLogger(AreaController.class);
	@Autowired
	private AreaService areaService;

	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TArea> findAll(){
		try {
			return areaService.findAll();
		} catch (Exception e) {
			logger.info("用户"+CurrentUser.returnCurrentUser()+"查询所有的地区数据失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult findPage(int page, int rows){
		try {
			return areaService.findPage(page, rows);
		} catch (Exception e) {
			logger.info("用户"+CurrentUser.returnCurrentUser()+"分页返回全部区域信息失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 增加
	 * @param area
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TArea area){
		try {
			areaService.add(area);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			logger.info("用户"+CurrentUser.returnCurrentUser()+"增加区域信息失败,Exception:"+e);
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param area
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TArea area){
		try {
			areaService.update(area);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			logger.info("用户"+CurrentUser.returnCurrentUser()+"修改区域信息失败,Exception:"+e);
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}	
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public TArea findOne(Integer id){
		try {
			return areaService.findOne(id);
		} catch (Exception e) {
			logger.info("用户"+CurrentUser.returnCurrentUser()+"根据id获取区域信息失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(@RequestBody Integer [] ids){
		try {
			areaService.delete(ids);
			return new Result(true, "删除成功");
		} catch (Exception e) {
			logger.info("用户"+CurrentUser.returnCurrentUser()+"删除区域信息失败,Exception:"+e);
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
		/**
	 * 查询+分页
	 * @param brand
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody TArea area, int page, int rows  ){
		try {
			return areaService.findPage(area, page, rows);
		} catch (Exception e) {
			logger.info("用户"+CurrentUser.returnCurrentUser()+"分页条件查询区域信息失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 根据parentId查询子分类
	 */
	@RequestMapping("/findByParentId")
	public List<TArea> findByParentId(Integer parentId){
		try {
			return areaService.findByParentId(parentId);
		} catch (Exception e) {
			logger.info("用户"+CurrentUser.returnCurrentUser()+"根据父id查询子区域信息失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}
}
