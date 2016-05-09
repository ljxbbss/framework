package com.zlebank.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zlebank.common.vo.PageVO;
import com.zlebank.model.AccountBook;
import com.zlebank.model.vo.AccountBookVo;
@Repository
public interface AccountBookDao {
    int deleteByPrimaryKey(Integer bookId);

    int insert(AccountBook record);

    int insertSelective(AccountBook record);

    AccountBook selectByPrimaryKey(Integer bookId);

    int updateByPrimaryKeySelective(AccountBook record);

    int updateByPrimaryKey(AccountBook record);
    
    /**
     * @param pageVO
     * @param accountBook
     * @return
     * @description:查询记账流水列表分页
     */
	public List<AccountBook> findListPage(@Param("pageVO")PageVO<AccountBookVo> pageVO,@Param("accountBookVO")AccountBookVo accountBookVo);
	/**
	 * @param AccountBook
	 * @return
	 * @description:查询记录数
	 */
	public int findListPageCount(@Param("accountBookVO")AccountBookVo accountBookVo);

    
}