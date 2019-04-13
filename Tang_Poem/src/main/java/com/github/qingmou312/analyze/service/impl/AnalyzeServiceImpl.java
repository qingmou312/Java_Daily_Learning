package com.github.qingmou312.analyze.service.impl;

import com.github.qingmou312.analyze.dao.AnalyzeDao;
import com.github.qingmou312.analyze.entity.PoertyInfo;
import com.github.qingmou312.analyze.model.AuthorCount;
import com.github.qingmou312.analyze.model.WordCount;
import com.github.qingmou312.analyze.service.AnalyzeService;
import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.NlpAnalysis;

import java.util.*;

/**
 * Author:lidan
 * Created:2019/4/11
 */
public class AnalyzeServiceImpl implements AnalyzeService {

    private final AnalyzeDao analyzeDao;

    public AnalyzeServiceImpl(AnalyzeDao analyzeDao) {
        this.analyzeDao = analyzeDao;
    }

    @Override
    public List<AuthorCount> analyzeAuthorCount() {
        /**
         * 此处结果并未排序
         * 排序方式
         * 1.DAO层sql排序
         * 2.service层进行数据排序
         */
        List<AuthorCount> authorCounts = analyzeDao.analyzeAuthorCount();
//        Collections.sort(authorCounts, new Comparator<AuthorCount>() {
//            @Override
//            public int compare(AuthorCount o1, AuthorCount o2) {
//                return -1 * o1.getCount().compareTo(o2.getCount());
//            }
//        });
        return authorCounts;
    }

    /**
     * 词云分析
     *
     * @return
     */
    @Override
    public List<WordCount> analyzeWordCloud() {
        /**
         * 1.查询出所有的数据
         * 2.取出title content
         * 3.分词 过滤/w null 空 len<2 /nr人名
         * 4.统计
         */
        Map<String, Integer> map = new HashMap<>();
        List<PoertyInfo> poertyInfos = analyzeDao.queryAllPoetryINfo();
        for (PoertyInfo poertyInfo : poertyInfos) {
            List<Term> terms = new ArrayList<>();
            String title = poertyInfo.getTitle();
            String content = poertyInfo.getContent();

            terms.addAll(NlpAnalysis.parse(title).getTerms());
            terms.addAll(NlpAnalysis.parse(content).getTerms());

            Iterator<Term> iterator = terms.iterator();
            while (iterator.hasNext()) {
                Term term = iterator.next();
                /**
                 * 词性的过滤
                 */
                if (term.getNatureStr() == null || term.getNatureStr().equals("w")||term.getNatureStr().equals("nr")) {
                    iterator.remove();
                    continue;
                }
                /**
                 * 词的长度的过滤
                 */
                if (term.getRealName().length() < 2) {
                    iterator.remove();
                    continue;
                }
                //统计
                String realName = term.getRealName();
                Integer count = 0;
                if (map.containsKey(realName)) {
                    count = map.get(realName) + 1;
                } else {
                    count = 1;
                }
                map.put(realName, count);
            }
        }
        List<WordCount> wordCounts = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            WordCount wordCount = new WordCount();
            wordCount.setCount(entry.getValue());
            wordCount.setWord(entry.getKey());
            wordCounts.add(wordCount);
        }
        return wordCounts;
    }
}
