package test.mybatis;

import test.vo.BoardVo;
import test.vo.BoardVo;

import java.util.HashMap;
import java.util.List;

//test.mybatis.MembersMapper.xml과 같은 이름의 패키지에 같은 이름의 인터페이스를 만든다
public interface BoardMapper {
    //test.mybatis.MembersMapper.xml파일의 id속성과 같은 이름으로 메서드를 만든다
    int insert(BoardVo vo);
    int count(HashMap<String,Object> map);
    List<BoardVo> list(HashMap<String,Object> map);
    BoardVo prev(int num);
    BoardVo next(int num);
    BoardVo detail(int num);
    int addHit(int num);
}
