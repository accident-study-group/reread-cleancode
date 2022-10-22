import 'package:drift/native.dart';
import 'package:team_collaboration_tool/data/data_sources/team_dao.dart';
import 'package:team_collaboration_tool/data/data_sources/team_dao_impl.dart';
import 'package:team_collaboration_tool/db/database.dart';
import 'package:test/test.dart';

void main() async {
  late Database database;
  late TeamDao teamDao;

  group('TeamDao', () {
    final String teamName = 'Team HDD';

    group('.insertTeam()', () {
      setUp(() {
        database = Database(NativeDatabase.memory(setup: (database) {}));
        teamDao = TeamDaoImpl(database);
      });

      tearDown(() async {
        await database.close();
      });

      test('성공했을 때 return 1', () async {
        var insertResult = await teamDao.insertTeam(teamName);
        expect(insertResult, equals(1));
      });

      test('데이터 중복으로 실패했을 때 throw SqliteException', () async {
        // 이미 데이터가 들어가있는 DB를 제공받은 상태로 하고싶은데, 아직까지는 하는 방법을 찾지 못함.
        var insertResult = await teamDao.insertTeam(teamName);
        expect(insertResult, equals(1));

        expect(() => teamDao.insertTeam(teamName),
            throwsA(isA<SqliteException>()));
      });
    });

    group('.getTeams()', () {
      setUp(() {
        database = Database(NativeDatabase.memory(setup: (database) {}));
        teamDao = TeamDaoImpl(database);
      });

      tearDown(() async {
        await database.close();
      });
      test('DB에 팀이 없을 때 return []', () async {
        var getTeamsResult = await teamDao.getTeams();
        expect(getTeamsResult, equals([]));
      });

      test('DB에 팀이 있을 때 return [TeamEntity()]', () async {
        // 이미 데이터가 들어가있는 DB를 제공받은 상태로 하고싶은데, 아직까지는 하는 방법을 찾지 못함.
        var insertResult = await teamDao.insertTeam(teamName);
        expect(insertResult, equals(1));

        var getTeamsResult = await teamDao.getTeams();
        expect(getTeamsResult.isNotEmpty, isTrue);
        expect(getTeamsResult.length, equals(1));
        expect(getTeamsResult[0], isA<TeamEntity>());
      });
    });

    group('.getTeamOrNull()', () {
      setUp(() {
        database = Database(NativeDatabase.memory(setup: (database) {}));
        teamDao = TeamDaoImpl(database);
      });

      tearDown(() async {
        await database.close();
      });
      test('DB에 검색한 이름의 팀이 없을 때 return null', () async {
        var getTeamOrNullResult = await teamDao.getTeamOrNull(teamName);
        expect(getTeamOrNullResult, isNull);
      });

      test('DB에 팀이 있을 때 return TeamEntity()', () async {
        // 이미 데이터가 들어가있는 DB를 제공받은 상태로 하고싶은데, 아직까지는 하는 방법을 찾지 못함.
        var insertResult = await teamDao.insertTeam(teamName);
        expect(insertResult, equals(1));

        var getTeamOrNullResult = await teamDao.getTeamOrNull(teamName);
        expect(getTeamOrNullResult, isNotNull);
        expect(getTeamOrNullResult, isA<TeamEntity>());
      });
    });

    group('.deleteTeam()', () {
      setUp(() {
        database = Database(NativeDatabase.memory(setup: (database) {}));
        teamDao = TeamDaoImpl(database);
      });

      tearDown(() async {
        await database.close();
      });
      test('DB에 삭제할 이름의 팀이 없을 때 return 0', () async {
        var deleteTeamResult = await teamDao.deleteTeam(teamName);
        expect(deleteTeamResult, equals(0));
      });

      test('DB에 팀이 있을  return 1', () async {
        // 이미 데이터가 들어가있는 DB를 제공받은 상태로 하고싶은데, 아직까지는 하는 방법을 찾지 못함.
        var insertResult = await teamDao.insertTeam(teamName);
        expect(insertResult, equals(1));

        var deleteTeamResult = await teamDao.deleteTeam(teamName);
        expect(deleteTeamResult, equals(1));
      });
    });
  });
}
