package net.onlineshop.services.manage.questionnaireItem.dao;import net.onlineshop.core.DaoManager;import net.onlineshop.services.manage.questionnaireItem.bean.QuestionnaireItem;public interface QuestionnaireItemDao extends DaoManager<QuestionnaireItem> {		/**	 * 根据问卷ID和题目名称检查题目是否存在	 * @param questionnaireItem	 * @return	 */	int uniqeItem(QuestionnaireItem questionnaireItem);	/**	 * 根据问卷ID和题目名称删除指定的题目	 * @param item	 */	void deleteQuestionItem(QuestionnaireItem item);}