package com.boku.www.controller;
import java.util.Date;
import java.util.List;

import com.boku.www.pojo.TProjectData;
import com.boku.www.pojo.system.UUser;
import com.boku.www.utils.Count;
import com.boku.www.utils.CurrentUser;
import com.boku.www.utils.PageResult;
import com.boku.www.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.boku.www.service.ProjectDataService;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/projectData")
@CrossOrigin//解决跨域问题
public class ProjectDataController {
	private static Logger logger = LoggerFactory.getLogger(ProjectDataController.class);
	@Autowired
	private ProjectDataService projectDataService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TProjectData> findAll(){
		/*long a = System.currentTimeMillis();
		projectDataService.findAll();
		long b = System.currentTimeMillis();
		System.out.println(b-a);*/
		try {
			return projectDataService.findAll();
		} catch (Exception e) {
			logger.info("用户"+CurrentUser.returnCurrentUser()+"查询所有的项目数据失败,Exception:"+e);
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
			return projectDataService.findPage(page, rows);
		} catch (Exception e) {
			logger.info("用户"+CurrentUser.returnCurrentUser()+"分页查询所有的项目数据失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 增加
	 * @param projectData
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TProjectData projectData){
		try {
			projectDataService.add(projectData);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			logger.info("用户"+CurrentUser.returnCurrentUser()+"增加项目数据失败,Exception:"+e);
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param projectData
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TProjectData projectData){
		try {
			projectDataService.update(projectData);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			logger.info("用户"+CurrentUser.returnCurrentUser()+"修改项目数据失败,Exception:"+e);
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
	public TProjectData findOne(Integer id){
		try {
			return projectDataService.findOne(id);
		} catch (Exception e) {
			logger.info("用户"+CurrentUser.returnCurrentUser()+"根据id获取项目实体失败,Exception:"+e);
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
			projectDataService.delete(ids);
			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			logger.info("用户"+CurrentUser.returnCurrentUser()+"删除项目数据失败,Exception:"+e);
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
		/**
	 * 查询+分页
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public PageResult search(@RequestBody TProjectData projectData, int page, int rows  ){
		try {
			return projectDataService.findPage(projectData, page, rows);
		} catch (Exception e) {
			logger.info("用户"+CurrentUser.returnCurrentUser()+"分页条件查询项目数据失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 批量确认项目数据
	 * @param ids
	 * @return
	 */
	@RequestMapping("/confirmProjectDataStatus")
	public Result confirmProjectDataStatus(@RequestBody Integer [] ids){
		try {
			projectDataService.confirmProjectDataStatus(ids);
			return new Result(true, "确认成功");
		} catch (Exception e) {
			logger.info("用户"+CurrentUser.returnCurrentUser()+"确认项目数据失败,Exception:"+e);
			e.printStackTrace();
			return new Result(false, "确认失败");
		}
	}

	/**
	 * 批量确认奖励数据
	 * @param ids
	 * @return
	 */
	@RequestMapping("/confirmPrizeStatus")
	public Result confirmPrizeStatus(@RequestBody Integer [] ids){
		try {
			projectDataService.confirmPrizeStatus(ids);
			return new Result(true, "确认成功");
		} catch (Exception e) {
			logger.info("用户"+CurrentUser.returnCurrentUser()+"确认奖励数据失败,Exception:"+e);
			e.printStackTrace();
			return new Result(false, "确认失败");
		}
	}

	/**
	 * 批量确认奖励和项目数据
	 * @param ids
	 * @return
	 */
	@RequestMapping("/confirmProjectAndPrizeStatus")
	public Result confirmProjectAndPrizeStatus(@RequestBody Integer [] ids){
		try {
			projectDataService.confirmProjectAndPrizeStatus(ids);
			return new Result(true, "确认成功");
		} catch (Exception e) {
			logger.info("用户"+CurrentUser.returnCurrentUser()+"批量确认奖励和项目数据失败,Exception:"+e);
			e.printStackTrace();
			return new Result(false, "确认失败");
		}
	}

	/**
	 * 统计各地区项目的数量
	 */
	@RequestMapping("/countTheNumberOfProjectDataInEachArea")
	public List<Count> countTheNumberOfProjectDataInEachArea(){
		try {
			return projectDataService.countTheNumberOfProjectDataInEachArea();
		} catch (Exception e) {
			logger.info("用户"+CurrentUser.returnCurrentUser()+"统计各地区项目的数量失败,Exception:"+e);
			e.printStackTrace();
			return null;
		}
	}
}
