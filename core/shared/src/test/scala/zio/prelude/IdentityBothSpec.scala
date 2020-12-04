package zio.prelude

import zio.test._
import zio.test.laws._

object IdentityBothSpec extends DefaultRunnableSpec {

  def spec: ZSpec[Environment, Failure] =
    suite("IdentityBothSpec")(
      suite("laws")(
        testM("either")(checkAllLaws(IdentityBoth)(GenF.either(Gen.anyInt), Gen.anyInt)),
        testM("list")(checkAllLaws(IdentityBoth)(GenF.list, Gen.anyInt)),
        testM("option")(checkAllLaws(IdentityBoth)(GenF.option, Gen.anyInt)),
        testM("try")(checkAllLaws(IdentityBoth)(GenFs.tryScala, Gen.anyInt)),
        testM("nested[list, option]")(checkAllLaws(IdentityBoth)(GenFs.nested(GenF.list, GenF.option), Gen.anyInt)),
        testM("both[list,option]")(checkAllLaws(IdentityBoth)(GenFs.both(GenF.list, GenF.option), Gen.anyInt))
      )
    )
}
